<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>在线支付</p>
    </header>

    <!-- 订单信息部分 -->
    <h3>订单信息：</h3>
    <div class="order-info">
      <p>
        {{ orders.business.businessName }}
        <i class="fa fa-caret-down" @click="detailetShow"></i>
      </p>
      <p>&#165;{{ (orders.orderTotal - totalpoints * 0.1).toFixed(1) }}</p>
    </div>

    <!-- 订单明细部分 -->
    <ul class="order-detailet" v-show="isShowDetailet">
      <li v-for="item in orders.list" :key="item">
        <p>{{ item.food.foodName }} x {{ item.quantity }}</p>
        <p>&#165;{{ (item.food.foodPrice * item.quantity).toFixed(1) }}</p>
      </li>
      <li>
        <p>配送费</p>
        <p>&#165;{{ orders.business.deliveryPrice }}</p>
      </li>
    </ul>

    <!-- 支付方式部分 -->
    <ul class="payment-type">
      <li>
        <img src="../assets/alipay.png">
        <input type="radio" name="Way" checked>
      </li>
      <li>
        <img src="../assets/wechat.png">
        <input type="radio" name="Way">
      </li>
    </ul>
    <div class="payment-button">
      <button @click="toSuccess()">确认支付</button>
    </div>

    <!-- 底部菜单部分 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from '../components/Footer.vue';

export default {
  name: 'UserPayment',
  data() {
    return {
      orderId: this.$route.query.orderId,
      orders: {
        business: {}
      },
      isShowDetailet: false,
      fromWalletId: 0,
      toWalletId: 0,
      balance: '',
      orderArr: 0,
      totalpoints: 0
    }
  },
  created() {
    this.user = this.$getSessionStorage('user');
    this.$axios.get('OrdersController/getOrdersById', {
      params: {
        orderId: this.orderId
      }
    }).then(response => {
      //debugger;
      this.orders = response.data //.result;
    }).catch(error => {
      console.error(error);
    });
  },
  mounted() {
    //这里的代码是实现：一旦路由到在线支付组件，就不能回到订单确认组件。
    //先将当前url添加到history对象中
    history.pushState(null, null, document.URL);
    //popstate事件能够监听history对象的变化
    window.onpopstate = () => {
      this.$router.push({
        path: '/index',
        query: {}
      });
    }
  },
  unmounted() {
    window.onpopstate = null;
  },
  methods: {
    toSuccess() {
      // 检查订单ID是否存在
      if (!this.orderId) {
        alert('订单ID不存在，请重试');
        return;
      }
      // 使用正确的订单ID
      this.$axios.post('OrdersController/OrderPaymentById', this.$qs.stringify({
        orderId: this.orderId // 修改：使用this.orders.id而非this.orderArr.orderId
      })).then(response => {
        const result = response.data;
        if (result === 1) {
          // 支付成功后的处理
          this.Statement = '已支付';
          // 可以添加提示或跳转到订单详情页
          alert('支付成功');
          this.$router.push({
            path: '/PaySuccess',
            query: {orderId: this.orderId}
          });
        } else {
          alert('支付失败，请重试');
        }
      }).catch(error => {
        console.error('支付请求失败', error);
        alert('支付请求失败，请稍后重试');
      });
    },
  },
  components: {
    Footer
  }

}
</script>

<style scoped>
/****************** 总容器 ******************/
.wrapper {
  width: 100%;
  height: 100%;
}

/****************** header部分 ******************/
.wrapper header {
  width: 100%;
  height: 12vw;
  background-color: #6D28D9;
  color: #fff;
  font-size: 4.8vw;

  position: fixed;
  left: 0;
  top: 0;
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;
}

/****************** 订单信息部分 ******************/
.wrapper h3 {
  margin-top: 12vw;
  box-sizing: border-box;
  padding: 4vw 4vw 0;

  font-size: 4vw;
  font-weight: 300;
  color: #999;
}

.wrapper .order-info {
  box-sizing: border-box;
  padding: 4vw;
  font-size: 4vw;
  color: #666;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order-info p:last-child {
  color: orangered;
}

/****************** 订单明细部分 ******************/
.wrapper .order-detailet {
  width: 100%;
}

.wrapper .order-detailet li {
  width: 100%;
  box-sizing: border-box;
  padding: 1vw 4vw;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.wrapper .order-detailet li p {
  font-size: 3vw;
  color: #666;
}

/****************** 支付方式部分 ******************/
.wrapper .payment-type {
  width: 100%;
}

.wrapper .payment-type li {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;

  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #666;
}

.wrapper .payment-type li img {
  width: 33vw;
  height: 8.9vw;
}

.wrapper .payment-type li .fa-check-circle {
  font-size: 5vw;
  color: #38CA73;
}

.wrapper .payment-button {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;
}

.wrapper .payment-button button {
  width: 100%;
  height: 10vw;
  border: none;
  /*去掉外轮廓线*/
  outline: none;
  border-radius: 4px;
  background-color: #38CA73;
  color: #fff;
}
</style>
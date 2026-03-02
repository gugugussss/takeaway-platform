<template>
  <div class="wrapper">

    <!-- header部分 -->
    <header>
      <p>支付成功</p>
    </header>


    <div class="business-logo">
      <img src="../assets/success.png">
    </div>

    <!-- 返回首页 -->
    <div class="return-button">
      <button @click="toIndex">返回首页</button>
    </div>

    <!-- 底部菜单部分 -->
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from '../components/Footer.vue';

export default {
  name: 'PaySuccess',
  methods: {
    toIndex() {
      this.$router.push({
        path: '/index'
      });
    }
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

.wrapper .business-logo {
  width: 100%;
  height: 35vw;
  /*使用上外边距避开header部分*/
  margin-top: 20vw;
  display: flex;
  justify-content: center;
  align-items: center;
}

.wrapper .business-logo img {
  width: 40vw;
  height: 40vw;
  border-radius: 5px;
}


/****************** 支付成功部分 ******************/


.wrapper .return-button {
  width: 100%;
  box-sizing: border-box;
  padding: 4vw;
  margin-top: 20vw;
}

.wrapper .return-button button {
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
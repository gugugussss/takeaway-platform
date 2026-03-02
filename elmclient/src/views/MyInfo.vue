<template>
  <div class="wrapper">
    <heade>
      <p>我的</p>
    </heade>
    <!-- header部分 -->
    <header></header>

    <!-- 个人信息部分 -->
    <ul class="userinfob">
      <li @click="logOut()">
        <p><i class="fa fa-sign-out"></i>退出登录</p>
        <i class="fa fa-angle-right"></i>
      </li>
    </ul>
    <Footer></Footer>
  </div>
</template>

<script>
import Footer from '../components/Footer.vue'

export default {
  name: 'MyInfo',

  methods: {
    // 退出登录 (实际退出操作,依赖响应拦截器)
    logOut(user) {
      this.$removeSessionStorage('user');
      let result = this.$getSessionStorage('user');
      if (result == null) {
        alert('退出成功');
        this.$router.push('/index');
      } else {
        alert('退出失败')
      }
    }
  },
  components: {
    Footer: Footer
  },
}
</script>

<style scoped="scoped">
/*************** 总容器 ***************/
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #F5F5F5;
}

.wrapper heade {
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

/*************** header ***************/
.wrapper header {
  width: 100%;
  height: 12vw;
  padding-top: 2vw;
  background-color: #0097FF;
  display: flex;
  align-items: center;
  color: #fff;
  font-size: 4.8vw;
}

.wrapper header img {
  width: 16vw;
  height: 16vw;
  border-radius: 8vw;
  margin-left: 5vw;
}

.wrapper header p {
  margin-left: 5vw;
  color: #fff;
  font-size: 5.6vw;
  font-weight: 700;
}

/*************** userinfo ***************/

.wrapper .userinfob {
  width: 100%;
  padding-bottom: 14vw;
}

.wrapper .userinfob li {
  width: 100%;
  height: 12vw;
  box-sizing: border-box;
  padding: 0 4vw;
  margin-top: 3.6vw;
  background-color: #fff;

  display: flex;
  justify-content: space-between;
  align-items: center;

  user-select: none;
  cursor: pointer;
}

.wrapper .userinfob li p {
  font-size: 4.2vw;
  color: #666;
}

.wrapper .userinfob li i {
  /*左右两边的图标样式一样*/
  font-size: 5vw;
  color: #0097FF;
  margin-right: 3vw;
}

.wrapper .userinfoa {
  width: 100%;
  height: 20vw;
  border: solid 1px #cecece;
  background-color: #fff;
  left: 0;
  bottom: 0;
  display: flex;
  justify-content: space-around;
  align-items: center;
}

.wrapper .userinfoa li {
  /*li本身的尺寸完全由内容撑起*/
  box-sizing: content-box;
  width: 33%;
  border-right: solid #9f9f9f 1px;
  padding: 9px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: #999;
  user-select: none;
  cursor: pointer;
}

.wrapper .userinfoa li p {
  font-size: 3.5vw;
}

.wrapper .userinfoa li img {
  width: 12vw;
  height: 12vw;
}
</style>
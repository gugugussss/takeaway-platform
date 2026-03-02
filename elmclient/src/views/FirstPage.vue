<template>
  <div class="bg">
    <img src="../assets/elmfp.png">
  </div>
</template>
<script>
export default {
  data() {
    return {
      count: ''//倒计时
    }
  },


  created() {
    this.threeGo()
  },

  methods: {
    //3秒后进入跳转页面
    threeGo() {
      const TIME_COUNT = 2.5;
      if (!this.timer) {
        this.count = TIME_COUNT;
        this.show = false;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= TIME_COUNT) {
            this.count--;
          } else {
            this.show = true;
            clearInterval(this.timer);
            this.timer = null;
            //跳转的页面写在此处
            this.$router.push({
              path: 'index'
            });
          }
        }, 1000)
      }
    }
  }
}
</script>
<style>
.bg {
  background-color: #0097FF;
  background-size: cover;
}

.bg img {
  width: 100%;
  height: 100%;
}

</style>
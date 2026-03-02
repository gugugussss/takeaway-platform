<template>

  <li class="goback" @click="goBack">
    <i class="fa fa-arrow-left"></i>
  </li>

</template>

<script>
export default {
  name: 'GoBack',
  methods: {
    goBack() {
      this.$router.go(-1);
    }
  }
}

</script>

<style>
.wrapper .goback li.parent {
  z-index: 9999;
  position: fixed;
  top: 0;
  color: #fff;
}
</style>
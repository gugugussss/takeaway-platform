<template>
	<ul class="footer">

		<li @click="toIndex">
			<i class="fa fa-home"></i>
			<p>首页</p>
		</li>
		<li>
			<i class="fa fa-compass"></i>
			<p>发现</p>
		</li>
		<li @click="toOrderList">
			<i class="fa fa-file-text-o"></i>
			<p>订单</p>
		</li>
		<li @click="toMyInfo">
			<i class="fa fa-user-o"></i>
			<p>我的</p>
		</li>
	</ul>
</template>
<script>
	export default {
		name:  'AppFooter',
		methods: {
			goBack() {
				this.$router.go(-1); // 返回上一页
			},
			toIndex() {
				this.$router.push({
					path: '/index'
				});
			},
			toOrderList() {
				this.$router.push({
					path: '/orderList'
				});
			},
			toMyInfo() {
				this.$router.push({
					path: '/myInfo'
				});
			}
		}
	}
</script>
<style>

	.wrapper .footer {
		width: 100%;
		height: 14vw;
		border-top: solid 1px #DDD;
		background-color: #6D28D9;
		position: fixed;
		left: 0;
		bottom: 0;
		display: flex;
		justify-content: space-around;
		align-items: center;
	}

	.wrapper .footer li {
		/*li本身的尺寸完全由内容撑起*/
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		color: #DDD;
		user-select: none;
		cursor: pointer;
	}

	.wrapper .footer li p {
		font-size: 2.8vw;
	}

	.wrapper .footer li i {
		font-size: 5vw;
	}

</style>
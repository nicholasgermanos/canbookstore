<!--https://freefrontend.com/css-animation-examples/-->
<template lang="pug">
.grid
	- for (let i = 0; i < 50; i++) {
		hr
	- }
</template>

<script>
export default {
	name: 'ShootingStars'
};
</script>

<style scoped lang="scss">
.grid {
	position: fixed;
	display: flex;
	flex-direction: column;
	width: 100%;
	height: 100%;
	z-index: -100;
}

hr {
	border-top: 1px dashed grey;
}
</style>

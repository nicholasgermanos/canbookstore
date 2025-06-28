<!--https://freefrontend.com/css-animation-examples/-->
<template lang="pug">
.grid
	.vr
	.paper
		- for (let i = 0; i < 50; i++) {
			hr
		- }
</template>

<script>
export default {
	name: 'ShootingStars'
};
</script>

<style scoped lang="stylus">
.grid {
	padding-bottom: $bottom-of-page;
	padding-top: $top-of-page;
}

.paper {
	position: relative;
	display: flex;
	flex-direction: column;
	height: 100%;
	z-index: -100;
	background: $theme-background;
}

hr {
	border-top: 1px dashed grey;
	margin: 31px 0 0 0;
}

.vr {
	position: absolute;
	top: 0;
	width: $vertical-rule-left;
	height: 100%;
	background: none;
	border-color: #fea4a4;
	border-width: 1px;
	border-style: none solid none none;
	z-index: -99;
	opacity: 1;

}


@media (max-width: $grid-breakpoint-sm) {
	.vr {
		width: 0;
		display: none;
	}
}
</style>

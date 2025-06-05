<template>
	<BackgroundDesign id="stars" />
	<MenuBar :key="menuBarKey" />
	<div v-if="!isFullScreen" class="newlines">
		<router-view class="main-content" />
		<FooterBar />
	</div>
</template>

<script>
import MenuBar from '@/components/MenuBar.vue';
import BackgroundDesign from '@/components/BackgroundDesign.vue';
import FooterBar from '@/components/FooterBar.vue';
import { ref } from 'vue';

export default {
	name: 'App',
	setup() {
		const menuBarKey = ref(0);
		const forceRerender = () => {
			menuBarKey.value++;
		};

		return {
			menuBarKey,
			forceRerender,
		};
	},
	components: {
		BackgroundDesign,
		MenuBar,
		FooterBar
	}
};
</script>

<style lang="stylus">
#app
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

  margin-top: 56px;
  min-height 100vh

  display flex
  flex 1 1 100%

.main-content
  display flex
  flex-grow 1
  width 100%

</style>

<template>
	<div>

		<p>TEST HERE</p>
		<button v-on:click="test">test</button>
	</div>
</template>

<script>
import OpenLibraryService from '@/services/openLibraryService.js'
export default {
	name: "ToBeRead",
	data() {
		return {
			bookDetails: undefined
		}
	},
	methods: {
		test() {
			OpenLibraryService.lookupBook().then(response => {
				this.bookDetails = response.data
			})
		}
	}
}
</script>

<style lang="scss" scoped>
p {
	margin-top: 90px;
	color: black;
}
</style>

<template>
	<div v-if="book" class="book-details">

		<div class="main-details">

			<div class="cover-image-container">
				<img class="cover-image" src="../assets/the-hunger-games.jpg">
			</div>
			<div class="text-details">
				<p class="title">{{ book.title }}</p>
				<div class="blank-line"></div>
				<p class="author">by {{ getFormattedAuthorNames(book.author_name) }}</p>
			</div>
		</div>

	</div>
</template>

<script>
import { getFormattedAuthorNames } from '@/utils/bookUtils';


export default {
	name: "BookDetails",
	props: {
		book: String
	},
	methods: {
		getFormattedAuthorNames
	}

}
</script>

<style lang="styl" scoped>
.book-details {
	font-family: Monaco;
	display: flex;
	flex-direction: column;
	text-align: left;
	width: 100%;
	line-height: 32px;
}
 
.main-details {
	width: 100%;
	display: flex;
	flex-wrap: wrap-reverse;
}

.cover-image-container {
	.cover-image {
		max-height: inherit;
		min-width: inherit;
		position: absolute;
	}
	min-height: 960px;
	min-width: 600px;
	margin-right: 64px;
}

</style>

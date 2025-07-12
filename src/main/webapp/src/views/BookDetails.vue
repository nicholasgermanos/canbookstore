<template>
	<div v-if="book" class="book-details">
		<div class="main-details">
			<div class="cover-image-container">
				<img class="cover-image" src="../assets/the-hunger-games.jpg">
			</div>
			<div class="text-details">
				<p class="title">{{ book.title }}</p>
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

.text-details {
	margin-bottom: 32px;
}

.cover-image-container {
	.cover-image {
		max-height: inherit;
		min-width: inherit;
		position: relative;
	}
	min-height: 13%;
	min-width: 6%;
	margin-right: 64px;
}

@media (max-width: $grid-breakpoint-sm) {
	.cover-image-container {
		margin-right: 0px;
	}

	.main-details {
		justify-content: center;
	}
}
</style>

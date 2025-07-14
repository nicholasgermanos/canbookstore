<template>
	<div v-if="book" class="book-details">
		<div class="main-details">
			<div class="cover-image-container">
				<img class="cover-image" src="../assets/the-hunger-games.jpg">
			</div>
			<div class="text-details-short">
				<p class="title">{{ book.title }}</p>
				<p class="author">by {{ getFormattedAuthorNames(book.author_names) }}</p>
			</div>
		</div>
		<div class="text-details-long">
			<p class="description">{{book.description}}</p>
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
	padding: 0 32px 0 32px;
}

.main-details {
	width: 100%;
	display: flex;
	flex-wrap: wrap-reverse;
}

.text-details-short {
	margin-bottom: 32px;
}

.text-details-long {
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
	margin-bottom: 32px;
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

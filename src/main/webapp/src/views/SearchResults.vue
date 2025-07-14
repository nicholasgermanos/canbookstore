<template>
	<div class="book-shelf" v-if="this.$props.searchData">
		<div v-for="book in this.$props.searchData.data.search.results.hits" v-bind:key="book.key">
			<div v-on:click="goToBook(book.document)" class="book-container">
				<img class="cover-image" src="../assets/the-hunger-games.jpg">
				<div class="text-details">
					<p class="book-title">{{ book.document.title }}</p>
					<p>by {{ getFormattedAuthorNames(book.document.author_names ) }}</p>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { getFormattedAuthorNames } from '@/utils/bookUtils';

export default {
	name: "SearchResults",
	props: {
		searchData: Object
	},
	data() {
		return {
			searchResults: undefined
		}

	},
	methods: {
		getFormattedAuthorNames,
		goToBook(book) {
			this.$emit("showSearchedBook", book)
		},
	},
}
</script>

<style lang="styl" scoped>

.book-shelf {
	margin-top: 12px;
	display: flex;
	flex-direction: column;
	justify-content: start;
	flex-wrap: wrap;
}

.book-container {
	cursor: pointer;
	border-width: 2px;
	display: flex;
	flex-direction: row;
	margin-bottom: 32px;
}

.book-title {
	font-size: 25px;
}

.text-details {
	display: flex;
	flex-direction: column;
}

.cover-image {
	min-height: 204px;
	max-height: 204px;
	margin-bottom: 20px;
	margin-right: 20px;
}

@media (max-width: $grid-breakpoint-sm) {
	.book-container {
		
	}
}
</style>

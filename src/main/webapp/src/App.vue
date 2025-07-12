<template>

	<MenuBar :key="menuBarKey" />

	<div class="newlines crimson-text-regular">
		<div class="main-content">
			<div class="top-spacer"></div>
			<div v-if="searchMode" id="search-mode">
				<BookDetails v-if="showBookDetails" :book="selectedBook" />

				<p v-if="showSearchResults && searchResults" class="title">Search Results</p>
				<div class="blank-line"></div>
				<SearchResults v-if="showSearchResults" @show-searched-book="showSearchedBook"
					:search-data="searchResults" />
			</div>
		</div>

	</div>

	<div class="search-bar-container">
		<form @submit.prevent="searchByTerm">
			<input placeholder="Search..." v-model="searchQuery" v-on:focus="openSearchResults" id="search-bar" />
		</form>
	</div>

	<FooterBar />


</template>

<script>
import MenuBar from './components/MenuBar.vue';
import FooterBar from '@/components/FooterBar.vue';
import openLibraryService from './services/openLibraryService';
import { ref } from 'vue';
import SearchResults from './views/SearchResults.vue';
import BookDetails from './views/BookDetails.vue';

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
		MenuBar,
		SearchResults,
		BookDetails,
		FooterBar
	},
	data() {
		return {
			// Page lengths
			pageMedium: false,
			pageLong: false,

			// Show sections
			showSearchResults: false,
			showBookDetails: false,
			searchMode: false,

			// Data
			searchQuery: undefined,
			searchResults: undefined,
			selectedBook: undefined,
		}
	},
	methods: {
		async searchByTerm() {
			this.openSearchResults()
			await openLibraryService.lookupBook(this.searchQuery).then(response => {
				if (response !== undefined) {
					console.log(response.data)
					this.searchResults = response.data
				}
			})

		},
		showSearchedBook(book) {
			console.log(book)
			this.openBookDetails()
			this.selectedBook = book
		},
		closeSearchResults() {
			this.showSearchResults = false
		},
		openSearchResults() {
			this.enableSearchMode()
			this.closeBookDetails()
			this.showSearchResults = true
		},
		openBookDetails() {
			this.closeSearchResults()
			this.showBookDetails = true
		},
		closeBookDetails() {
			this.showBookDetails = false
		},
		enableSearchMode() {
			this.searchMode = true
		},
		disableSearchMode() {
			this.searchMode = false
		}
	}
};
</script>

<style lang="styl">
#app {
	font-family: Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;

	min-height: 100vh;

	display: flex;
	flex: 1 1 100%;

	flex-direction: column;

	height: fit-content;
}

.paper {
	margin-bottom: 32px;
}

.grid {
	filter: drop-shadow(-4px 1px 3px #000);
}

.main-content {
	line-height: 32px;
	padding-left: 16px;
	margin-top: 85px;
}

.search-bar-container {
	display: flex;
	flex-direction: column;
	flex-grow: 1;
	justify-content: center;
	background: $theme-brown;
	position: sticky;
	min-height: 60px;
	max-height: 60px;
	bottom: 0;
	padding: 10px
	input {
		height: 40px;
		width: calc(100% - 10px);
		padding-left: 15px;
	}
}

@media (max-width: $grid-breakpoint-sm) {
	.main-content {
		margin-top: 20px;
		padding: 20px;
	}
}

</style>

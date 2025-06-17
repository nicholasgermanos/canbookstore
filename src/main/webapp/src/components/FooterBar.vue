<template>
	<div class="footer-bar">
		<div v-if="bookDetails">
			<div v-for="book in bookDetails.docs" v-bind:key="book.key">

				<p>Author : {{ book.author_name }}</p>
			</div>
		</div>
		<div class="search-bar-container">
			<form @submit.prevent="searchByTerm">
				<input v-model="searchTerm" id="search-bar" />
			</form>
		</div>
		<div class="footer-content">
			<div class="footer-links">
				<router-link v-if="isLoggedIn()" to="/logout" class="fw-bold nav-link navbar-links">Logout</router-link>
				<router-link v-if="isLoggedOut()" to="/login" class="fw-bold nav-link navbar-links">Login</router-link>
				<router-link v-if="isLoggedOut()" to="/register" class="fw-bold nav-link navbar-links">Register
				</router-link>
				<router-link v-if="isAdmin()" to="/contribute" class="fw-bold nav-link navbar-links">Contribute
				</router-link>
				<router-link to="/about" class="fw-bold nav-link navbar-links">About</router-link>
				<router-link to="/contact" class="fw-bold nav-link navbar-links">Contact</router-link>
				<a href="https://github.com/nicholasgermanos/canbookstore" target="_blank"
					class="fw-bold nav-link navbar-links">See my code</a>
			</div>
		</div>
	</div>
</template>

<script>

import { isAdmin, isLoggedIn, isLoggedOut } from '@/utils/localStorageUtils';
import openLibraryService from '@/services/openLibraryService';


export default {
	name: 'MenuBar',
	methods: {
		isAdmin,
		isLoggedIn,
		isLoggedOut,
		async searchByTerm() {
			await openLibraryService.lookupBook(this.searchTerm).then(response =>
				this.bookDetails = response.data
			)
		}

	},
	data() {
		return {
			searchTerm: undefined,
			bookDetails: undefined
		}
	},

};
</script>

<style lang="stylus" scoped>
a:hover {
	cursor: pointer;
}

.footer-bar {
	display: flex;
	justify-content: space-evenly;
	position: relative;
	padding: 50px 10% 40px 10%;
	background: $theme-dark;
}

a {
	padding: 3px;
}

a:focus,
a:hover {
	color: $theme-white;
}

.footer-content {
	max-width: 100%;
	min-width: 100%;
	display: flex;
	flex-wrap: wrap-reverse;
	justify-content: space-around;
	z-index: 1;
}

.footer-links {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.newsletter-signup-container {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	justify-content: start;
	width: 50%;
}

h4 {
	color: $theme-white;
	padding: 5px;
}

.newsletter-form {
	display: flex;
	flex-wrap: nowrap;
	width: 100%;
	justify-content: start;
	margin-bottom: 30px;
}

input {
	height: 40px;
	width: 80%;
	max-width: 400px;
	padding-left: 10px;
	margin-right: 15px;
	margin-bottom: 10px;
	box-shadow: 1px 1px 0 0 $theme-white, 2px 2px 0 0 $theme-white, 3px 3px 0 0 $theme-white, 4px 4px 0 0 $theme-white, 5px 5px 0 0 $theme-white;
	border: 3px $theme-dark solid;
	background-color: $theme-white;
	color: $theme-dark;
}

button {
	color: $theme-dark;
	border-color: $theme-dark;
	box-shadow: 1px 1px 0 0 $theme-white, 2px 2px 0 0 $theme-white, 3px 3px 0 0 $theme-white, 4px 4px 0 0 $theme-white, 5px 5px 0 0 $theme-white;
}

@media (max-width: $grid-breakpoint-md) {
	.footer-bar {
		padding: 10px;
	}
}

.footer-links {
	align-items: center;
	padding: 0;
}

.footer-content {
	flex-direction: column-reverse;
	max-width: 100%;
	min-width: 100%;
	margin: 0;
	margin-top: 50px;
}

.newsletter-signup-container {
	align-items: center;
	width: 100%;
}

.newsletter-form {
	justify-content: center;
	flex-wrap: wrap;
}

@media (min-width: $grid-breakpoint-3xl) {}

.footer-content {
	max-width: 70%;
	min-width: 70%;

}
</style>

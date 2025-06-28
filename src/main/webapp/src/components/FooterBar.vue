<template>
	<div class="footer-bar">
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

export default {
	name: 'MenuBar',
	methods: {
		isAdmin,
		isLoggedIn,
		isLoggedOut
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
	background: $theme-brown;
	width: 100%;
}

a {
	padding: 3px;
	color: $theme-white-calm;
}

a:focus,
a:hover {
	color: $theme-white-calm;
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

h4 {
	color: $theme-white;
	padding: 5px;
}

@media (max-width: $grid-breakpoint-md) {
	.footer-bar {
		padding: 10px;
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
	}
}

@media (min-width: $grid-breakpoint-3xl) {
	.footer-content {
		max-width: 70%;
		min-width: 70%;

	}
}
</style>

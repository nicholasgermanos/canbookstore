<template>
	<div class="container form-container">
		<form @submit.prevent="submit" class="container blog-form">
			<div class="m-4">
				<h1>Hi, nice to meet you</h1>
				<div class="error" v-if="errorMessage">{{ errorMessage }}</div>
				<input v-model="user.firstName" placeholder="First Name" />
				<input v-model="user.lastName" placeholder="Surname" />
				<input v-model="user.email" placeholder="Email" />
				<input type="password" v-model="user.password" placeholder="Password" />
				<button class="nick-button" type="submit" label="Register">Register</button>
			</div>
		</form>
	</div>
</template>

<script>

import UserService from '@/services/userService';
import { isEmpty } from '@/utils/utils';

export default {
	name: "RegisterPage",
	data() {
		return {
			errorMessage: undefined,
			user: {
				firstName: null,
				lastName: null,
				email: null,
				password: null
			}
		}
	},
	methods: {
		submit() {
			UserService.register(this.user).then(response => {
				if (!isEmpty(response)) {
					this.errorMessage = response;
				}
			})
		}
	}
};
</script>

<style lang="stylus" scoped>
button {
	margin-top: 20px;
	width: 90%;
}

.form-container {
	width: 40%;
}
</style>

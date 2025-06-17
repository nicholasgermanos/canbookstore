<template>
	<div class="container form-container">
		<form @submit.prevent="submit" class="blog-form">
			<div class="m-4">
				<h1>Welcome back</h1>
				<h6>(login below)</h6>
				<input v-model="user.email" placeholder="Email" />
				<input type="password" v-model="user.password" placeholder="Password" />
				<button class="nick-button" type="submit" label="Login">Login</button>
			</div>
		</form>
	</div>
</template>

<script>
import UserService from '@/services/userService';
import router from '@/router';

export default {
	name: "LoginPage",
	data() {
		return {
			user: {
				email: null,
				password: null
			},
			rememberMe: false
		}
	},
	methods: {
		submit: function () {
			UserService.login(this.user)
			router.push("/")
		}
	}
};
</script>


<style lang="stylus" scoped>
h6 {
	font-size: 12px;
}

/* Remember me checkbox */
.remember-me {
	width: 100%;
	margin-top: 30px;
	display: block;
}

td {
	height: 100%;
}

input {
	margin-top: 0;
}
</style>

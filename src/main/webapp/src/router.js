import { createWebHistory, createRouter } from 'vue-router';

import HomePage from '@/views/HomePage.vue';
import LoginPage from '@/views/LoginPage.vue';
import RegisterPage from '@/views/RegisterPage.vue';
import LogoutPage from '@/views/LogoutPage.vue';
import ToBeRead from './views/ToBeRead.vue';

const routes = [

	{ name: 'root', path: '/', component: HomePage },
	{ name: 'login', path: '/login', component: LoginPage },
	{ name: 'logout', path: '/logout', component: LogoutPage },
	{ name: 'register', path: '/register', component: RegisterPage },
	{ name: 'error', path: '/error', component: HomePage },

	{ name: 'tbr', path: '/tbr', component: ToBeRead },
	{ name: 'library', path: '/library', component: HomePage },
	{ name: 'stats', path: '/stats', component: HomePage }
];

const router = createRouter({
	history: createWebHistory(),
	scrollBehavior() {
		return {
			top: 0
		}
	},
	routes
});

router.beforeEach((to, from, next) => {
	const publicPages = ['root', 'login', 'register', 'error', 'tbr'];
	const authRequired = !publicPages.includes(to.name);
	const loggedIn = localStorage.getItem('user');

	// trying to access a restricted page + not logged in
	// redirect to login page
	if (authRequired && !loggedIn) {
		next('/login');
	} else {
		next();
	}
});

export default router;

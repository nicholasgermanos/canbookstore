import { createApp } from 'vue'
import "@/styles/main.scss"
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap-grid.min.css'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import router from '@/router';

createApp(App)
	.use(router)
	.mount('#app')

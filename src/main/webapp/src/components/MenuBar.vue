<template>
	<div class="menu-bar">
		<nav class="navbar navbar-expand-sm fixed-top">
			<div class="container">
				<router-link to="/" role="button" class="fw-bold navbar-brand navbar-links">C.A.N.</router-link>
				<button class="hamburger navbar-links navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarToggle" aria-controls="navbarToggle" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="fa-solid fa-bars"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarToggle">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item">
							<router-link to="/library" class="fw-bold nav-link navbar-links">Library</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/tbr" class="fw-bold nav-link navbar-links">TBR</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/stats" class="fw-bold nav-link navbar-links">Stats</router-link>
						</li>
						<li class="nav-item">
							<router-link to="/accounts" class="fw-bold nav-link navbar-links">Account</router-link>
						</li>

					</ul>
				</div>
			</div>
		</nav>
	</div>
</template>

<script>

import { isLoggedIn, isLoggedOut } from '@/utils/localStorageUtils';
import { isMobile } from '@/utils/utils';

export default {
	name: 'MenuBar',
	methods: {
		isMobile,
		isLoggedIn,
		isLoggedOut,
		fullscreen: function () {
			this.$emit('fullscreen')
		},
	}
};
</script>

<style lang="stylus" scoped>
.navbar {

	button,
	span,
	a {
		&:hover {
			transform: scale(1.05);
			color: $theme-white;
		}

		&:focus {
			color: $theme-white;
			transition: ease 0.2s
		}
	}

	background: $theme-brown;

	.hamburger {
		border-color: $theme-white;
	}

	.hamburger:focus {
		box-shadow: none;
	}


}

.fullscreen-icon {
	margin-top: 6px;
	margin-left: 6px;

	a:hover {
		transform: none;
		transition: none;

		img {

			height: 23px;
		}
	}

	&:hover {
		transition: ease 0.2s;
		cursor: pointer;
		transform: scale(1.2);
	}

}
</style>

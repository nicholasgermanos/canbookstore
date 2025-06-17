// vue.config.js
const path = require('path');

module.exports = {
	chainWebpack: config => {
		const types = ['vue-modules', 'vue', 'normal-modules', 'normal'];
		types.forEach(type => {
			addStyleResource(config.module.rule('stylus').oneOf(type))
		});
	},
	devServer: {
		port: 3000,
		proxy: {
			'/api': {
				target: 'http://localhost:8080',
				ws: true,
				changeOrigin: true
			}
		}
	},
	publicPath:
		process.env.NODE_ENV === 'production' ? '/dist/' : '/',
};

function addStyleResource(rule) {
	rule.use('style-resources-loader')
		.loader('style-resources-loader')
		.options({
			patterns: [
				path.resolve(__dirname, './src/styles/main.styl')
			],
		});
}

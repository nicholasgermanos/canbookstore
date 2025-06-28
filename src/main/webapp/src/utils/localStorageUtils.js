import { isEmpty } from '@/utils/utils';

export function getLoggedIn() {
	const user = localStorage.getItem('user');

	if (isEmpty(user) === true) {
		return undefined;
	}

	return JSON.parse(user)
}

export function getLoggedInID() {
	return getLoggedIn().id
}

export function isAdmin() {
	return isLoggedIn() === true && localStorage.getItem('role') === 'ADMINISTRATOR'
}

export function isLoggedIn() {
	return isEmpty(getLoggedIn()) !== true
}

export function isLoggedOut() {
	return isLoggedIn() !== true
}

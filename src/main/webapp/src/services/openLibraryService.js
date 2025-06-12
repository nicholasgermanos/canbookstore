import axios, { AxiosHeaders } from 'axios';
const OPEN_LIBRARY_URL = "https://openlibrary.org/search.json?q="

class OpenLibraryService {

	lookupBook(searchTerm) {
		searchTerm = "Hunger Games"
		const headers = new Headers({
			"User-Agent": "MyAppName/1.0 (myemail@example.com)"
		})

		const axios_headers = new AxiosHeaders(headers)

		return axios.get(OPEN_LIBRARY_URL + searchTerm, axios_headers)
	}

}

export default new OpenLibraryService()

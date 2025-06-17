import axios from 'axios';

axios.defaults.baseURL = "/api/"

const GET_BOOK_WITH_SEARCH_TERM_URL = "booksWithSearchTerm/"

class OpenLibraryService {

	async lookupBook(searchTerm) {
		return axios.get(GET_BOOK_WITH_SEARCH_TERM_URL + searchTerm)
	}

}

export default new OpenLibraryService()

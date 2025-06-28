import { isEmpty } from "./utils"

export function getFormattedAuthorNames(authorList) {
	if (isEmpty(authorList)) {
		return "Unknown"
	}
	if (authorList.length == 1) {
		return authorList[0]
	}
	let authors = ""
	for (let author in authorList) {
		authors += author
		if (authors.includes("&") !== true && authorList.indexOf(author) !== authorList.length - 1) {
			authors += "&"
		}

	}

	return authors
}


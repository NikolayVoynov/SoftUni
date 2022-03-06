function attachEvents() {
    const urlPosts = 'http://localhost:3030/jsonstore/blog/posts';
    const urlComments = 'http://localhost:3030/jsonstore/blog/comments';

    let loadPostBtn = document.getElementById('btnLoadPosts');
    let viewPostsBtn = document.getElementById('btnViewPost');

    let selectPosts = document.getElementById('posts');
    let commentsField = document.getElementById('post-comments');

    loadPostBtn.addEventListener('click', loadPost);
    viewPostsBtn.addEventListener('click', loadComment);

    async function loadPost() {

        let res = await fetch(urlPosts);
        let dataPosts = await res.json();

        for (post in dataPosts) {
            let optionElement = document.createElement('option');
            optionElement.value = post;
            optionElement.textContent = dataPosts[post].title;
            selectPosts.appendChild(optionElement);
        }
    }

    async function loadComment() {

        let res = await fetch(urlComments);
        let dataComments = await res.json();

        commentsField.innerHTML = '';

        for (comment in dataComments) {

            if (dataComments[comment].postId == selectPosts.value) {
                let liElement = document.createElement('li');
                liElement.id = comment;
                liElement.textContent = dataComments[comment].text;
                commentsField.appendChild(liElement);

            }

        }

    }
}


attachEvents();
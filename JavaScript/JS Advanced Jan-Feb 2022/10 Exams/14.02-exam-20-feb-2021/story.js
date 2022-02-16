class Story {

    #comments;
    #likes;

    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this.#comments = [];
        this.#likes = [];
    }

    get likes() {
        if (this.#likes.length == 0) {
            return `${this.title} has 0 likes`;
        } else if (this.#likes.length == 1) {
            return `${this.#likes[0]} likes this story!`;
        } else {
            return `${this.#likes[0]} and ${this.#likes.length - 1} others like this story!`;
        }
    }

    like(username) {
        let hasLiked = this.#likes.includes(username);

        if (hasLiked) {
            throw new Error("You can't like the same story twice!");
        } else if (this.creator == username) {
            throw new Error("You can't like your own story!");
        } else {
            this.#likes.push(username)
            return `${username} liked ${this.title}!`;
        }
    }

    dislike(username) {
        let hasLiked = this.#likes.includes(username);

        if (!hasLiked) {
            throw new Error("You can't dislike this story!");
        } else {
            let index = this.likes.indexOf(username);
            this.#likes.splice(index, 1);
            return `${username} disliked ${this.title}`;
        }
    }

    comment(username, content, id) {
        let existId = this.#comments.some(x => x.newCommentId == id);

        if (id == undefined || !existId) {
            let newCommentId = this.#comments.length + 1;
            this.#comments.push({ newCommentId, username, content, replies: [] });

            return `${username} commented on ${this.title}`;
        } else if (existId) {
            let findComment = this.#comments.find(x => x.newCommentId == id);
            let replyId = `${id}.${findComment.replies.length + 1}`;
            replyId = Number(replyId);
            let newReply = { replyId, username, content };
            findComment.replies.push(newReply);

            return 'You replied successfully';
        }
    }

    toString(sortingType) {
        let title = `Title: ${this.title}`;
        let creator = `Creator: ${this.creator}`;
        let likes = `Likes: ${this.#likes.length}`;
        let commentsTitle = 'Comments:';
        let commentsArray = [];

        if (sortingType == 'asc') {
            this.#comments.sort((c1, c2) => c1.newCommentId - c2.newCommentId)
                .forEach(c => { c.replies.sort((r1, r2) => r1.replyId - r2.replyId) });

        } else if (sortingType == 'desc') {
            this.#comments.sort((c1, c2) => c2.newCommentId - c1.newCommentId)
                .forEach(c => { c.replies.sort((r1, r2) => r2.replyId - r1.replyId) });

        } else if (sortingType == 'username') {
            this.#comments.sort((c1, c2) => c1.username.localeCompare(c2.username))
                .forEach(c => { c.replies.sort((r1, r2) => r1.username.localeCompare(r2.username)) });

        }

        commentsArray.push(title);
        commentsArray.push(creator);
        commentsArray.push(likes);
        commentsArray.push(commentsTitle);

        this.#comments.forEach(c => {
            commentsArray.push(`-- ${c.newCommentId}. ${c.username}: ${c.content}`);

            c.replies.forEach(r => {
                commentsArray.push(`--- ${r.replyId}. ${r.username}: ${r.content}`);
            })
        })


        return commentsArray.join('\n');
    }
}


let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));

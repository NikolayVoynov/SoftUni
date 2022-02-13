class ArtGallery {

    constructor(creator) {
        this.creator = creator;
        this.possibleArticles = { picture: 200, photo: 50, item: 250 };
        this.listOfArticles = [];
        this.guests = []
    }

    addArticle(articleModel, articleName, quantity) {
        if (!this.possibleArticles[articleModel.toLowerCase()]) {
            throw new Error('This article model is not included in this gallery!');
        }

        let doExist = this.listOfArticles.some(art => art.articleName == articleName && art.articleModel == articleModel.toLowerCase());

        if (doExist) {
            let foundArticle = this.listOfArticles.find(art => art.articleName == articleName && art.articleModel == articleModel.toLowerCase());
            foundArticle.quantity += Number(quantity);

        } else {
            this.listOfArticles.push({
                articleModel: articleModel.toLowerCase(),
                articleName,
                quantity
            });
        }

        return `Successfully added article ${articleName} with a new quantity- ${quantity}.`;
    }

    inviteGuest(guestName, personality) {
        let doExist = this.guests.some(g => g.guestName == guestName);

        if (doExist) {
            throw new Error(`${guestName} has already been invited.`);

        } else {
            let points = 50;

            if (personality === 'Vip') {
                points = 500;

            } else if (personality === 'Middle') {
                points = 250;
            }

            this.guests.push({ guestName, points, purchaseArticle: 0 })
        }

        return `You have successfully invited ${guestName}!`;
    }

    buyArticle(articleModel, articleName, guestName) {
        let articleExist = this.listOfArticles.some(art => art.articleName == articleName && art.articleModel == articleModel.toLowerCase());

        if (!articleExist) {
            throw new Error('This article is not found.');
        } else {
            let foundArticle = this.listOfArticles.find(art => art.articleName == articleName && art.articleModel == articleModel.toLowerCase());

            if (foundArticle.quantity == 0) {
                return `The ${articleName} is not available.`;
            }

            let guestExist = this.guests.some(g => g.guestName == guestName);

            if (!guestExist) {
                return 'This guest is not invited.';
            } else {
                let foundGuest = this.guests.find(g => g.guestName == guestName);

                if (foundGuest.points < this.possibleArticles[foundArticle.articleModel]) {
                    return 'You need to more points to purchase the article.';

                } else {
                    let articlePoint = this.possibleArticles[foundArticle.articleModel];
                    foundGuest.points -= articlePoint;
                    foundGuest.purchaseArticle++;
                    foundArticle.quantity--;

                    return `${guestName} successfully purchased the article worth ${articlePoint} points.`;
                }
            }
        }
    }

    showGalleryInfo(criteria) {
        let result = [];
        let firstLine = '';

        if (criteria == 'article') {
            firstLine = 'Articles information:';
            result.push(firstLine);

            for (const a of this.listOfArticles) {
                result.push(`${a.articleModel} - ${a.articleName} - ${a.quantity}`);
            }

        } else if (criteria == 'guest') {
            firstLine = 'Guests information:';
            result.push(firstLine);

            for (const g of this.guests) {
                result.push(`${g.guestName} - ${g.purchaseArticle} `);
            }
        }

        return result.join('\n');
    }
}

// const artGallery = new ArtGallery('Curtis Mayfield');
// console.log(artGallery.addArticle('picture', 'Mona Liza', 3));
// console.log(artGallery.addArticle('Item', 'Ancient vase', 2));
// console.log(artGallery.addArticle('PICTURE', 'Mona Liza', 1));

// const artGallery = new ArtGallery('Curtis Mayfield');
// console.log(artGallery.inviteGuest('John', 'Vip'));
// console.log(artGallery.inviteGuest('Peter', 'Middle'));
// console.log(artGallery.inviteGuest('John', 'Middle'));

// const artGallery = new ArtGallery('Curtis Mayfield');
// artGallery.addArticle('picture', 'Mona Liza', 3);
// artGallery.addArticle('Item', 'Ancient vase', 2);
// artGallery.addArticle('picture', 'Mona Liza', 1);
// artGallery.inviteGuest('John', 'Vip');
// artGallery.inviteGuest('Peter', 'Middle');
// console.log(artGallery.buyArticle('picture', 'Mona Liza', 'John'));
// console.log(artGallery.buyArticle('item', 'Ancient vase', 'Peter'));
// console.log(artGallery.buyArticle('item', 'Mona Liza', 'John'));


const artGallery = new ArtGallery('Curtis Mayfield');
artGallery.addArticle('picture', 'Mona Liza', 3);
artGallery.addArticle('Item', 'Ancient vase', 2);
artGallery.addArticle('picture', 'Mona Liza', 1);
artGallery.inviteGuest('John', 'Vip');
artGallery.inviteGuest('Peter', 'Middle');
artGallery.buyArticle('picture', 'Mona Liza', 'John');
artGallery.buyArticle('item', 'Ancient vase', 'Peter');
console.log(artGallery.showGalleryInfo('article'));
console.log(artGallery.showGalleryInfo('guest'));




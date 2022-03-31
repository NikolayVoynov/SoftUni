import { html } from '../../node_modules/lit-html/lit-html.js';
import * as theatersService from '../api/theaters.js'
import { getUserData } from '../util.js';


const profileTemplate = (user, theaters, hasEvent) => html`
<section id="profilePage">
    <div class="userInfo">
        <div class="avatar">
            <img src="../../images/profilePic.png">
        </div>
        <h2>${user.email}</h2>
    </div>
    <div class="board">
        ${hasEvent
        ? html`
        ${theaters.map(eventTemplate)}`
        : html`
        <div class="no-events">
            <p>This user has no events yet!</p>
        </div>`
        }
    </div>
</section>`;

const eventTemplate = (theaterEvent) => html`
        <div class="eventBoard">
            <div class="event-info">
                <img src=${theaterEvent.imageUrl}>
                <h2>${theaterEvent.title}</h2>
                <h6>${theaterEvent.date}</h6>
                <a href="/details/${theaterEvent._id}" class="details-button">Details</a>
            </div>
        </div>`;


export async function profilePage(ctx) {
    const user = ctx.user;
    let userId = user._id;
     
    let theaters = await theatersService.getAllByUserId(userId);

    let hasEvent = true;

    if (theaters.length == 0) {
        hasEvent = false;
    }

    ctx.render(profileTemplate(user, theaters, hasEvent));
}
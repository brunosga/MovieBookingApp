# Mobile Apps 1 CA2

- Student Name: Bruno de souza Guimarães Almeida
- Student ID: 24845
- Course: BSC in Science in Computing (Year 2)

## Requirement Checklist

- [x] 1. Movie recycler view:
    - [x] 1.1. Create a Movie class with the structure specified in movie.json (provided on Moodle)
    - [x] 1.2. Obtain and fill data (minimum of 4 movies)
        - [x] 1.2.1. Obtain relevant movie data from Vue (https://www.myvue.com/cinema/dublin/whats-on) or your favourite provider and add data credits at the bottom of the app
        - [x] 1.2.2. Generate a random number between 0 and 15 for each movie and assign to seats_remaining
        - [x] 1.2.3. Start with an initial default seats_selected value of 0 for all movies
        - [x] 1.2.4. You shall fill random URLs for images from pixabay or other free image providers to begin with
    - [x] 1.3. Build a Recycler View using the specified template, refer to recycler_view_template_*.jpg (provided on Moodle)
    - [x] 1.4. If any seats are selected, show how many seats are selected and hide remaining seats
- [x] 2. Seat selection feature:
    - [x] 2.1. Clicking any item (anywhere on the item) on the movie recycler view should open a new MovieActivity, refer to movie_activity_*.jpg (provided on Moodle)
    - [x] 2.2. Add plus and minus icons, show seats_selected in the middle
    - [x] 2.3. On click plus/minus, update both seats_selected and seats_remaining for that movie
    - [x] 2.4. Add validation, when 0 seats selected minus is disabled, when 0 seats remaining plus is disabled
    - [x] 2.5. When back is pressed, the selected seats are retained and reflected in the recycler view. (Hint: If you don’t see any updates, call adapter notifyItemChanged as soon as you return to the recycler view activity)
- [x] 3. Bonus:
    - [x] 3.1. Add "filling fast" badge if less than 3 seats remaining
    - [x] 3.2. Use "Roboto Condensed" font to replicate same style
    - [x] 3.3. Use original movie images from myvue.com or your favourite provider (Hint: check get_movie_image_url.gif (provided on Moodle))


## Report

From the begging of this project I noticed that it would be a great challenge as I had to learn a lot of stuff that you will only learn by practicing loads of times.
I had to learn how to use the recycler view, adapter, how to use most of the thing by myself. 
One of the greatest challenge for me was getting an API, at first I thought that we had to use a real API, being fetch from a server, but then I realized that we had to use GIST using a JSON file, as you showed us in the lectures.
I was able to use a real API but it did not have enough information from what has been required, so I had to use a JSON file.
And that's when I started to have a real problem in front of me, I watched so many tutorials, and read so many documents about it, even watched your lecture again, but it did not bring to the solution, 
so I asked for my classmate and he helped me a lot by showing how to properly set everything that its needed to pass the information to the recycler view.
with his help I was able to move on, then I started to work on the seat selection feature, and I had to learn how to use the intent in another way that I had previously learned,
but after the biggest challenge that was the API issue, the rest of the requirements was easier to do, still a lot of things that I had to learn and practice, but I was able to do it.
When I got to the "only" design part was very fun, I created the name "Foxynema" which is a combination of Foxy and Cinema, Foxy comes from my username when I'm playing with my friends,
and also I created the logo, and in the end I was able to do the design that I wanted to do.
I had a lot of stress doing this project, but when I was able to get to do what I needed to do, I felt incredible, so it was worth the stress and I learned a lot of new things, 
and I hope that this project helps me in future projects.

Comments: regarding the "1.2.4." requirement, I was able to do it but I did not think that would have a good use on my app, I'm using it in the bottom of the main page but its just because it has to be in it,
I personally would not use it because its something that is not gonna match with my whole design, but its there.



## References and Credits

1. RecyclerView URL: [Link](https://www.youtube.com/watch?v=HtwDXRWjMcU&list=PLQkwcJG4YTCTq1raTb5iMuxnEB06J1VHX&index=21)
2. RecyclerView, ViewHolder, etc. URL: [Link](https://www.youtube.com/watch?v=Jp30bAXrZoM&list=PLtJ4906AWTH1OMt5LvnaP4yRUCiFaIga-)

## APK Releases

1. MovieApp [Link](https://github.com/brunosga/MovieBookingApp/releases/tag/MovieApp)

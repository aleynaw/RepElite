# My Personal Project

## *Workout Tracker and Generator*

For this project, I decided I would make a kind of **workout tracker and generator application**. Essentially, this 
program will be designed to take in basic information about its user such as name, ideal workout schedule and some 
favourite workouts and their respective working weights or PRs. From this, the application will prompt you when you 
begin to plan a workout if you would like to plan your own or have the app choose for you. If the user decides to plan 
their own, they will be given some categories as to what they want to focus on and can choose their exercises from 
there. If the user wants the application to generate a workout, they will still be prompted to choose a category to 
focus on, but from there the app will recommend a random set of workouts in that category, supplying ideal 
working-weights and the PR (if asked for). The targeted audience for this app is generic lifters who are tired of 
planning their workouts every time they go to the gym, those trying to find new exercises to do, or those looking to 
track their progress.

This project is of interest to me mostly because I plan on using it. I think it is a neat way to keep track of your 
progress, especially if you happen to take long breaks in between your gym visits, as most of us had to do recently. I 
also sometimes get quite uncreative when planning my workouts, and this will help me to stop repeating the same ones 
every time I go just because they are the only ones I can remember.

##*User Stories*

- As a user, I want to be able to **create** a profile with my name, age, and skill level
- As a user, I want to be able to **view** my profile
- As a user, I want to be able to **browse** the exercises catalogue
- As a user, I want to be able to **add** exercises to my workout plan for the day

- As a user, I want to be able to **save** current my workout plan to file
- As a user, I want to be able to **load** a saved workout plan from file
- As a user, I want to be able to have my profile **stored** after creating it
- As a user, I want to be able to **load** a previously saved profile

##*Phase 4: Task 2*

Thu Mar 31 17:21:26 PDT 2022
Created a Profile


Thu Mar 31 17:21:32 PDT 2022
Added 'Seated Rows' workout to WorkoutPlan


Thu Mar 31 17:21:32 PDT 2022
Added 'DeadLift' workout to WorkoutPlan


Thu Mar 31 17:21:32 PDT 2022
Added 'Barbell Squat' workout to WorkoutPlan


Thu Mar 31 17:21:32 PDT 2022
Added 'Shoulder Press' workout to WorkoutPlan

##*Phase 4: Task 3*

Overall, my biggest change would be with the TrackerApp and GUI relationship. Most of the code in the TrackerApp is
now irrelevant, so its associations to the JSON classes and the rest of model classes are unnecessary. So I would 
remove the TrackerApp all together and have my main class instantiate my GUI instead.
Beyond that, I would also try and find a way to not have to split my JSON classes into two different ones with the same
functions, or make an interface for my Readers and Writers and just have the separate JSON classes implement it 
separately. 

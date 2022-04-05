Mobile App 1 - BSC20921 - Semester 2
Continuous Assessment 3: Github Repos AppAssignment

Name : Amara Pedroza Terrazas 
Student ID: 25308

## Requirements Checklist
    1. Get username and display corresponding user details and repositories as shown in the screenshot above
   - [x]      Show the error message with a big warning icon e.g. if not username is not found (done)
   - [x]     If user is found, show information for user and for each repo as shown in the screenshot(done)
    - [x]   Test and record screencast for usernames torvalds, Rich-Harris, JakeWharton, and newtoneinstein. (You can show yours too!)(done)
    2. Extend the same functionality for organizations:
   
  - [x] Add a radio button to select username or orgname(done)
  - [x] Show information about the organization and repositories
  - [x] Test and record screencast for orgnames microsoft, facebook, uber, and ultrabot.
     
   3. Bonus Points:
      - [x] Design Similarity E.g. colors, fonts, dark mode, etc. ( I tried)
      - [x] Use short number format e.g. 42200 as 42.2k (done)


## (Optional) Extra features implemented
    - color circles depending on the language

## Report:
To carry out this assignment it was necessary to try to understand the requirements. I started by seeing the Main Activity (layout and functionalities).
Then the second activity layout was done, trying to make it similar to the one that was given to us.

To make the second activity layout, I tried to use a similar aesthetic. I was able to make the circles change color according to the language (similar to the last activity). I had difficulties this time making the image round (previously it was not a problem). I tried different ways, but I opted to change the ImageView to a Shapeable Image View (experiment a new possibility to make a circle) .

To be able to parse the given information from the API I used OkHTTP3 and gson. In order to import the image, Picasso was used.

Among the flaws of my code, I think it could be more orderly and create more classes and methods. Because the code can be repetitive.

To finish this assessment took me a lot of time, and I needed some external resources. But in the end it was worth it and I think it helped me apply the concepts learned in class. 





## References:
https://stackoverflow.com/questions/14393996/how-to-get-the-current-user-name-from-login-in-android
https://stackoverflow.com/questions/45132729/get-string-extra-from-activity-kotlin
https://medium.com/@chris_42047/making-rest-calls-in-kotlin-android-using-okhttp-and-couroutines-dcff3b525ad6
https://square.github.io/okhttp/
https://developer.android.com/reference/kotlin/android/graphics/Outline
https://stackoverflow.com/questions/5618402/how-to-draw-rounded-rectangle-in-android-ui
https://codeinu.net/language/java/c1198552-android-change-background-drawable-color-programmatically
https://gist.github.com/nprk/999faa0d324e54bd59bae7def933b495
https://square.github.io/okhttp/recipes/
https://github.com/square/retrofit

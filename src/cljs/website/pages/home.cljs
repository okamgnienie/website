(ns website.home)

(defn home []
  [:div {:class "view view--home"}
   [:div {:class "container-fluid landing"}
    [:div {:class "landing__text"} "I'm just a placeholder."]]
   [:div {:class "container article"}

    [:p "My name is " [:strong "Przemyslaw Hardyn"] " and I was born in " [:strong "Cracow"] "," [:strong " Poland"] ". What you can see here is my kingdom, where I was free of limits, specifications and time schedules, to create what I truly believe describes me."]

    [:div {:class "article__separator"} "•"]

    [:p "I have a " [:strong "Bachelor Degree"] " in " [:strong "Applied Computer Science"] " with specialisation in " [:strong "Software Engineering"] ". Currently working on my " [:strong "Masters Degree"] " in the same field, at Cracow University Of Economics, with specialisation in " [:strong "Intelligent Systems"] "."]

    [:div {:class "article__separator"} "•"]

    [:p "I’ve " [:strong "two years"] " of professional experience, but I’m programming for much longer than that. I was working on various projects, ranging from " [:strong "games"] " to " [:strong "data mining systems"] ". I have extensive experience in designing and creating " [:strong "web animations"] " and " [:strong "user experiences"] ". All of the projects that I can share information about, you can find in the " [:strong "work"] " section."]

    [:p "Currently I’m taking part in one year internship at " [:strong "CERN"] " - European Organisation for Nuclear Research in " [:strong "Geneva"] ", " [:strong "Switzerland"] ". My responsibilities include designing and improving " [:strong "user interfaces"] " of various information systems, creating them with the latest web technologies, as well as working on structures of " [:strong "databases"] " and " [:strong "APIs"] "."]

    [:p "Before I used to work in a software house company called " [:strong "Codete"] " in " [:strong "Cracow"] ", " [:strong "Poland"] ". I’ve gained there priceless skills, knowledge and friends. By then my work was mostly focused on " [:strong "JavaScript"] " development of "[:strong "complex information systems"] "."]

    [:p "Most of my experience includes working with web technologies such as: JavaScript (ES5, ES6), AngularJS, Babel, Webpack, Gulp, CSS, SASS, LESS, HTML and PHP."]

    [:div {:class "article__separator"} "•"]

    [:p "Since I believe that JavaScript should be considered as " [:strong "“Assembler of XXI century”"] ", from all of the languages that you can transpile to JS, I decided to develop my " [:strong "ClojureScript"] " skills. Mostly because of well designed language, great community and the best development tools (Leiningen, Google Closure, Figwheel)."]]])

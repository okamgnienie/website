(ns website.home)

(defn landing-section []
  [:div.container-fluid.landing
   [:div.landing__text "I'm just a placeholder."]])

(defn home []
  [:div.view.view--home

   [landing-section]

   [:div.container.article

    [:p "My name is " [:strong "Przemyslaw Hardyn"] " and I was born in " [:strong "Cracow"] "," [:strong " Poland."]]

    [:p "I have a " [:strong "Bachelor Degree"] " in " [:strong "Applied Computer Science"] " with specialisation in " [:strong "Software Engineering"] ". Currently working on my " [:strong "Masters Degree"] " in the same field, at Cracow University Of Economics, with specialisation in " [:strong "Intelligent Systems"] "."]

    [:div.article__separator "•"]

    [:p "I’ve " [:strong "two years"] " of professional experience, but I’m programming for much longer than that. I was working on various projects, ranging from " [:strong "games"] " to " [:strong "data mining systems"] ". I have extensive experience in designing and creating " [:strong "web animations"] " and " [:strong "user experiences"] "."]

    [:div.article__separator "•"]

    [:p
     "Most of my experience includes working with web technologies such as: "
     "ClojureScript, JavaScript (ES5, ES6), AngularJS, React, Redux, Babel, Webpack, Gulp, CSS, SASS, LESS, HTML and PHP."]

    [:div.article__separator "•"]

    [:p "Feel free to contact me via " [:a {:href "#/contact"} "contact page"] "."]]])

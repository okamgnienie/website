(ns website.navbar)

(defn component []
  [:ul
   [:li [:a {:href "/"} "Home"]]
   [:li [:a {:href "/work"} "Work"]]
   [:li [:a {:href "/hours"} "Hours"]]
   [:li [:a {:href "/visuals"} "Visuals"]]
   [:li [:a {:href "/contact"} "Contact"]]])

(ns website.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [reagent.core :as r]

              [website.home :refer [home]]
              [website.work :refer [work]]
              [website.hours :refer [hours]]
              [website.visuals :refer [visuals]]
              [website.contact :refer [contact]]

              [website.styles :refer [style]]
              [website.navbar :refer [navbar]]
              [website.footer :refer [footer]]

              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

(def state-name (r/atom "home"))

;; -------------------------
;; Views

(defn current-page []
  [:div
   [:link {:rel "stylesheet" :href "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"}]
   [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css?family=Roboto:300,400"}]
   (style)
   [navbar state-name]
   [(session/get :current-page)]
   [footer]])

;; -------------------------
;; Routes

(secretary/defroute "/" []
  ((session/put! :current-page #'home)
   (reset! state-name "home")))

(secretary/defroute "/work" []
  ((session/put! :current-page #'work)
   (reset! state-name "work")))

(secretary/defroute "/hours" []
  ((session/put! :current-page #'hours)
   (reset! state-name "hours")))

(secretary/defroute "/visuals" []
  ((session/put! :current-page #'visuals)
   (reset! state-name "visuals")))

(secretary/defroute "/contact" []
  ((session/put! :current-page #'contact)
   (reset! state-name "contact")))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))

(ns website.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]

              [website.home :refer [home]]
              [website.work :refer [work]]
              [website.hours :refer [hours]]
              [website.visuals :refer [visuals]]
              [website.contact :refer [contact]]

              [website.styles :refer [style]]
              [website.navbar :refer [navbar]]

              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

;; -------------------------
;; Views

(defn current-page []
  [:div
   [:link {:href "https://fonts.googleapis.com/css?family=Roboto:300,400" :rel "stylesheet"}]
   (style)
   (navbar)
   [(session/get :current-page)]])

;; -------------------------
;; Routes

(secretary/defroute "/" []
  (session/put! :current-page #'home))

(secretary/defroute "/work" []
  (session/put! :current-page #'work))

(secretary/defroute "/hours" []
  (session/put! :current-page #'hours))

(secretary/defroute "/visuals" []
  (session/put! :current-page #'visuals))

(secretary/defroute "/contact" []
  (session/put! :current-page #'contact))

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

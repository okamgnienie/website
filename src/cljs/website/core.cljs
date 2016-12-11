(ns website.core
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as r]

            [website.home :refer [home]]
            [website.work :refer [work]]
            [website.hours :refer [hours]]
            [website.visuals :refer [visuals]]
            [website.contact :refer [contact]]

            [website.navbar :refer [navbar]]
            [website.footer :refer [footer]]))


;; -------------------------
;; Application state atom

(def app-state (r/atom {}))

;; -------------------------
;; Browser history

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize application routes

(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
    (swap! app-state assoc :name "home")
    (swap! app-state assoc :page :home))

  (defroute "/work" []
    (swap! app-state assoc :name "work")
    (swap! app-state assoc :page :work))

  (defroute "/hours" []
    (swap! app-state assoc :name "hours")
    (swap! app-state assoc :page :hours))

  (defroute "/visuals" []
    (swap! app-state assoc :name "visuals")
    (swap! app-state assoc :page :visuals))

  (defroute "/contact" []
    (swap! app-state assoc :name "contact")
    (swap! app-state assoc :page :contact))

  (hook-browser-navigation!))

;; -------------------------
;; Routes

(defmulti current-page #(@app-state :page))
(defmethod current-page :home []
  [:div
   [navbar #(@app-state :name)]
   [home]
   [footer]])
(defmethod current-page :work []
  [:div
   [navbar #(@app-state :name)]
   [work]
   [footer]])
(defmethod current-page :hours []
  [:div
   [navbar #(@app-state :name)]
   [hours]
   [footer]])
(defmethod current-page :visuals []
  [:div
   [navbar #(@app-state :name)]
   [visuals]
   [footer]])
(defmethod current-page :contact []
  [:div
   [navbar #(@app-state :name)]
   [contact]
   [footer]])
(defmethod current-page :default []
  [:div "Error 404!"])

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [current-page] (.getElementById js/document "app")))

(defn ^:export init []
  (app-routes)
  (mount-root))

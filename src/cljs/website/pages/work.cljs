(ns website.work
  (:require [website.navbar :as navbar]))

(defn view []
  [:div [:h2 "Welcome to work page"]
   (navbar/component)])

(ns website.hours
  (:require [website.navbar :as navbar]))

(defn view []
  [:div [:h2 "Welcome to hours page"]
   (navbar/component)])

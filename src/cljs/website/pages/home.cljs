(ns website.home
  (:require [website.navbar :as navbar]))

(defn view []
  [:div [:h2 "Welcome to mekeekke"]
   (navbar/component)])

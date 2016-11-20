(ns website.styles
  (:require [website.navbar-animations :refer [all]]
            [website.reset-styles :refer [reset]]
            [website.navbar-styles :refer [styles]]
            [website.main-styles :refer [main]]
            [website.footer-styles :as footer]))

(defn style []
  [:style reset main styles all footer/styles])

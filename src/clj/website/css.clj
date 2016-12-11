(ns website.css
  (:require [website.reset-styles :refer [reset]]
            [website.navbar-animations :as animations]
            [website.navbar-styles :as navbar]
            [website.main-styles :as main]
            [website.footer-styles :as footer]
            [website.visuals-styles :as visuals]
            [website.contact-styles :as contact]
            [website.hours-styles :as hours]
            [website.rainbow-text :refer [rainbow-text]]))

(def styles
  [reset
   animations/all
   navbar/styles
   main/styles
   footer/styles
   visuals/styles
   contact/styles
   hours/styles
   rainbow-text])

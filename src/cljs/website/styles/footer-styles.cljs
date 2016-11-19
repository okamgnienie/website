(ns website.footer-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass]]
            [garden.stylesheet :refer [at-media]]
            [website.variables :refer [mobile-max black-1 gray-2]]))

;; Main
(defclass footer)
(defclass footer__credits)
(defclass footer__contact-icons)
(defclass footer__link)

(def styles
  (css

   ;; - - - MAIN - - -

   [footer {:min-height "80px"
            :background-color gray-2
            :padding "10px 0 0 0"}]

   [footer__credits footer__contact-icons {:display "inline-block"
                                           :margin-bottom "10px"}]

   [footer__credits {:float "left"}]

   [footer__contact-icons {:float "right"}]

   (at-media {:max-width mobile-max}

             [footer__contact-icons {:float "left"
                                     :clear "left"}]

             [footer {:padding "10px"}])

   [footer__link {:color black-1
                  :text-decoration "none"
                  :margin-right "8px"}]))

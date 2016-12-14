(ns website.footer-styles
  (:require [garden.def :refer [defstyles]]

            [garden.selectors :refer [defclass]]

            [garden.stylesheet :refer [at-media]]

            [website.variables :refer [desktop-min
                                       black-1
                                       gray-2
                                       gray-4
                                       white-1]]))

;; Main
(defclass footer)
(defclass footer__credits)
(defclass footer__contact-icons)
(defclass footer__link)

;; Themes
(defclass footer--bright)
(defclass footer--dark)

(defstyles styles

  ;; - - - MAIN - - -

  [footer {:min-height "80px"
           :padding "10px 0 0 0"}]

  [footer__credits footer__contact-icons {:display "inline-block"
                                          :margin-bottom "10px"}]

  [footer__credits {:float "left"}]

  [footer__contact-icons {:float "right"}]

  (at-media {:max-width desktop-min}

            [footer__contact-icons {:float "left"
                                    :clear "left"}]

            [footer {:padding "10px"}])

  [footer__link {:text-decoration "none"
                 :margin-right "8px"}]

  ;; Themes

  [footer--bright {:background-color gray-2}
   [footer__link footer__credits {:color black-1}]]

  [footer--dark {:background-color gray-4}
   [footer__link footer__credits {:color white-1
                                  :font-weight 300}]]

  )

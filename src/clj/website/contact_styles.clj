(ns website.contact-styles
  (:require [garden.def :refer [defstyles]]

            [garden.selectors :refer [i
                                      defclass
                                      hover
                                      defclass
                                      focus
                                      textarea
                                      input]]

            [website.variables :refer [gray-2
                                       gray-3
                                       linkedin-color
                                       facebook-color
                                       github-color
                                       twitter-color]]))
;; --------------
;; Custom classes

(defclass view--contact)

(defclass contacts)
(defclass contacts__icon)
(defclass contacts__icon--vsco)

(defclass contact-form)

;; ------
;; Styles

(defstyles styles

  ;; --------------
  ;; View container

  [view--contact

   [contacts {:display "flex"
              :justify-content "space-around"}]

   [contacts__icon {:min-width "40px"
                    :padding "50px 5px"
                    :text-align "center"
                    :color gray-3
                    :text-decoration "none"
                    :font-style "normal"
                    :cursor "default"}
    [i {:transition "color .3s ease"
        :cursor "pointer"}]]

   [contacts__icon--vsco
    [i {:font-size "29px"
        :font-weight 300
        :line-height "50px"
        :font-style "normal"}]
    [(i hover) {:-webkit-background-clip "text"
                :color "transparent !important"
                :transition "none !important"
                :animation "rainbow-text 0.3s infinite"}]]

   [contacts__icon (i hover) {:transition "color 0.3s ease"}
    [:&.fa-linkedin {:color linkedin-color}]
    [:&.fa-facebook {:color facebook-color}]
    [:&.fa-github {:color github-color}]
    [:&.fa-twitter {:color twitter-color}]]

   [contact-form
    [:textarea {:width "100%"
                :height "200px"
                :border-radius 0
                :display "block"
                :margin-bottom "16px"
                :resize "none"
                :transition "border-color 0.3s ease"
                :padding "10px"
                :font-size "20px"
                :font-weight 300}]
    [:input {:background-color gray-3
             :border-radius 0
             :border "none"
             :color gray-2
             :font-size "20px"
             :float "right"
             :font-weight "300"
             :text-transform "uppercase"
             :padding "10px 30px"
             :min-width "150px"}]]

   ])

(ns website.rainbow-text
  (:require [garden.def :refer [defstyles]]
            [garden.selectors :refer [defclass]]
            [garden.stylesheet :refer [at-keyframes]]))

(def rainbow-red "#FF0000")
(def rainbow-orange "#FF9C00")
(def rainbow-yellow "#F5FF00")
(def rainbow-green "#3CF10E")
(def rainbow-cyan "#01FFE5")
(def rainbow-blue "#0024FF")
(def rainbow-purple "#C500FF")
(def rainbow-pink "#FF009C")

(defclass rainbow-text)
(defclass rainbow-text--infinite)

(defn get-gradient [c1 c2 c3 c4 c5 c6 c7 c8]
  (str "-webkit-gradient(linear,
                         left top,
                         right top,
                         color-stop(0.00, " c1 "),
                         color-stop(0.14, " c2 "),
                         color-stop(0.28, " c3 "),
                         color-stop(0.42, " c4 "),
                         color-stop(0.56, " c5 "),
                         color-stop(0.70, " c6 "),
                         color-stop(0.84, " c7 "),
                         color-stop(1.00, " c8 "))"))

(defstyles rainbow-text

  [rainbow-text {:background-clip "text"
                 :color "transparent !important"}]

  [rainbow-text--infinite {:aniamtion "rainbow-test .3s infinite"}]

  (at-keyframes "rainbow-text"

                [:0%
                 {:background-image (get-gradient rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink)}]

                [:14%
                 {:background-image (get-gradient rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple)}]

                [:28%
                 {:background-image (get-gradient rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue)}]

                [:42%
                 {:background-image (get-gradient rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan)}]

                [:56%
                 {:background-image (get-gradient rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green)}]

                [:70%
                 {:background-image (get-gradient rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange
                                                  rainbow-yellow)}]

                [:84%
                 {:background-image (get-gradient rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red
                                                  rainbow-orange)}]

                [:100%
                 {:background-image (get-gradient rainbow-orange
                                                  rainbow-yellow
                                                  rainbow-green
                                                  rainbow-cyan
                                                  rainbow-blue
                                                  rainbow-purple
                                                  rainbow-pink
                                                  rainbow-red)}]))

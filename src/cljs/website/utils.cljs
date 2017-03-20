(ns website.utils)

(defn validate-email [email]
  (string?
   (re-find #"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"email)))

(def riddles [{:question "Ten plus twenty plus twelve is equal to?" :answer 42}
              {:question "1 dozen is equal to?" :answer 12}
              {:question "How many days has year?" :answer 365}])

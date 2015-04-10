(ns paint-cljs.modern
  (:require [jayq.core :as $]))


(comment

($/ajax "http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=20&q=http://feeds.feedburner.com/AscoDeVida"
      {:dataType "jsonp"
       :success  (fn [data]
          (doseq [entry (.-entries (.-feed (.-responseData data)))]
              ($/append (js/$ "#content")
                (str "<div class='item fit'><dl><dt class='title round info label fit'>" (clojure.string/replace (.-title entry) #" y su ADV" "")
                     "</dt><dd class='fit txt'>" (get (clojure.string/split (.-content entry) #"ADV\u003cbr") 0) "</dd></dl></div><br/>"))
              )
          )})

)



($/ajax "http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=20&q=http://www.reddit.com/r/php/.rss"
      {:dataType "jsonp"
       :success  (fn [data]

          (.log js/console data)

          (doseq [entry (.-entries (.-feed (.-responseData data)))]
              ($/append (js/$ "#content")
                (str "<div class='item fit'><dl><dt class='title round info label fit'><a href='" (.-link entry) "'>"  (.-title entry)
                     "</a></dt><dd class='fit txt'>" (get (clojure.string/split (.-content entry) #"submitted by") 0) "</dd></dl></div><br/>"))
              )
          )})

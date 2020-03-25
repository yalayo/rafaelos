(ns specs.produtcs.show-product
  (:require [clojure.spec.alpha :as s]))

(s/def ::component
  (s/keys :req-un [::product]))


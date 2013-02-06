package org.obl.hb

/**
* FIXME: capire sintassi, in particolare dei parameters rfc2616 - sect 3.7
*/
object Mime extends Enumeration {

  object MimeValue {
    def apply(name: String): Value = new Val(nextId, name)
  }

  object application {

    val atom_xml = MimeValue("application/atom+xml")
    val EDI_X12 = MimeValue("application/EDI-X12")
    val EDIFACT = MimeValue("application/EDIFACT")
    val json = MimeValue("application/json")
    val javascript = MimeValue("application/javascript")
    val octet_stream = MimeValue("application/octet-stream")
    val ogg = MimeValue("application/ogg")
    val pdf = MimeValue("application/pdf")
    val postscript = MimeValue("application/postscript")
    val rss_xml = MimeValue("application/rss+xml")
    val soap_xml = MimeValue("application/soap+xml")
    val font_woff = MimeValue("application/font-woff")
    val xhtml_xml = MimeValue("application/xhtml+xml")
    val xml_dtd = MimeValue("application/xml-dtd")
    val xop_xml = MimeValue("application/xop+xml")
    val zip = MimeValue("application/zip")
    val x_gzip = MimeValue("application/x-gzip")
    
    val vnd_oasis_opendocument_text = MimeValue("application/vnd.oasis.opendocument.text")
    val vnd_oasis_opendocument_spreadsheet = MimeValue("application/vnd.oasis.opendocument.spreadsheet")
    val vnd_oasis_opendocument_presentation = MimeValue("application/vnd.oasis.opendocument.presentation")
    val vnd_oasis_opendocument_graphics = MimeValue("application/vnd.oasis.opendocument.graphics")
    val vnd_ms_excel = MimeValue("application/vnd.ms-excel")
    val vnd_openxmlformats_officedocument_spreadsheetml_sheet = MimeValue("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    val vnd_ms_powerpoint = MimeValue("application/vnd.ms-powerpoint")
    val vnd_openxmlformats_officedocument_presentationml_presentation = MimeValue("application/vnd.openxmlformats-officedocument.presentationml.presentation")
    val msword = MimeValue("application/msword")
    val vnd_openxmlformats_officedocument_wordprocessingml_document = MimeValue("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    val vnd_mozilla_xul_xml = MimeValue("application/vnd.mozilla.xul+xml")
    val vnd_google_earth_kml_xml = MimeValue("application/vnd.google-earth.kml+xml")
    
    val x_www_form_urlencoded = MimeValue("application/x-www-form-urlencoded")
    val x_dvi = MimeValue("application/x-dvi")
    val x_latex = MimeValue("application/x-latex")
    val x_font_ttf = MimeValue("application/x-font-ttf")
    val x_shockwave_flash = MimeValue("application/x-shockwave-flash")
    val x_stuffit = MimeValue("application/x-stuffit")
    val x_rar_compressed = MimeValue("application/x-rar-compressed")
    val x_tar = MimeValue("application/x-tar")
    val y_tmpl = MimeValue("text/x-jquery-tmpl")
    val x_javascript = MimeValue("application/x-javascript")
    val x_pkcs12 = MimeValue("application/x-pkcs12")
    val x_pkcs7_certificates = MimeValue("application/x-pkcs7-certificates")
    val x_pkcs7_certreqresp = MimeValue("application/x-pkcs7-certreqresp")
    val x_pkcs7_mime = MimeValue("application/x-pkcs7-mime")

  }
  object audio {

    val basic = MimeValue("audio/basic")
    val L24 = MimeValue("audio/L24")
    val mp4 = MimeValue("audio/mp4")
    val mpeg = MimeValue("audio/mpeg")
    val ogg = MimeValue("audio/ogg")
    val vorbis = MimeValue("audio/vorbis")
    val x_ms_wma = MimeValue("audio/x-ms-wma")
    val x_ms_wax = MimeValue("audio/x-ms-wax")
    val vnd_rn_realaudio = MimeValue("audio/vnd.rn-realaudio")
    val vnd_wave = MimeValue("audio/vnd.wave")
    val webm = MimeValue("audio/webm")

  }
  object image {

    val gif = MimeValue("image/gif")
    val jpeg = MimeValue("image/jpeg")
    val pjpeg = MimeValue("image/pjpeg")
    val png = MimeValue("image/png")
    val svg_xml = MimeValue("image/svg+xml")
    val tiff = MimeValue("image/tiff")
    val vnd_microsoft_icon = MimeValue("image/vnd.microsoft.icon")

  }
  object message {

    val http = MimeValue("message/http")
    val imdn_xml = MimeValue("message/imdn+xml")
    val partial = MimeValue("message/partial")
    val rfc822 = MimeValue("message/rfc822")

  }
  object model {

    val example = MimeValue("model/example")
    val iges = MimeValue("model/iges")
    val mesh = MimeValue("model/mesh")
    val vrml = MimeValue("model/vrml")
    val x3d_binary = MimeValue("model/x3d+binary")
    val x3d_vrml = MimeValue("model/x3d+vrml")
    val x3d_xml = MimeValue("model/x3d+xml")

  }
  object multipart {

    val mixed = MimeValue("multipart/mixed")
    val alternative = MimeValue("multipart/alternative")
    val related = MimeValue("multipart/related")
    val form_data = MimeValue("multipart/form-data")
    val signed = MimeValue("multipart/signed")
    val encrypted = MimeValue("multipart/encrypted")

  }
  object text {

    val cmd = MimeValue("text/cmd")
    val css = MimeValue("text/css")
    val csv = MimeValue("text/csv")
    val html = MimeValue("text/html")
    val javascript = MimeValue("text/javascript")
    val plain = MimeValue("text/plain")
    val xml = MimeValue("text/xml")

  }
  object video {

    val mpeg = MimeValue("video/mpeg")
    val mp4 = MimeValue("video/mp4")
    val ogg = MimeValue("video/ogg")
    val quicktime = MimeValue("video/quicktime")
    val webm = MimeValue("video/webm")
    val x_ms_wmv = MimeValue("video/x-ms-wmv")

  }
}
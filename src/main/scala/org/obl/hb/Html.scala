package org.obl.hb

import org.obl.hb.attributes._

object Html {
  
  import HBs._
  import BaseHBs._
  
  private def globalAttributes = new GlobalAttributes{}

  val html = new HtmlHB(Elem("html"))
  val head = new HeadHB(Elem("head"))
  val body = new BodyHB(Elem("body"))
  val script = new MetadataContentHB.Script(Elem("script"))
  val style = new MetadataContentHB.Style(Elem("style"))
  val title = new MetadataContentHB.Title(Elem("title"))
  
  val meta = new MetadataContentHB.Meta(Elem("meta"))
  val noscript = new MetadataContentHB.NoScript(Elem("noscript"))
  val link = new MetadataContentHB.Link(Elem("link"))
  val base = new MetadataContentHB.Base(Elem("base"))
  val command = new MetadataContentHB.Command(Elem("base"))
  
  val section = FlowHBImpl(Elem("section"), globalAttributes)
  val nav = FlowHBImpl(Elem("nav"), globalAttributes)
  val article = FlowHBImpl(Elem("article"), globalAttributes)
  val aside = FlowHBImpl(Elem("aside"), globalAttributes)

  val hgroup = new HGroupHB(Elem("hgroup"))

  val h1 = new HHB.HBImpl(Elem("h1"))
  val h2 = new HHB.HBImpl(Elem("h2"))
  val h3 = new HHB.HBImpl(Elem("h3"))
  val h4 = new HHB.HBImpl(Elem("h4"))
  val h5 = new HHB.HBImpl(Elem("h5"))
  val h6 = new HHB.HBImpl(Elem("h6"))

  val header = FlowHBImpl(Elem("header"), globalAttributes)
  val footer = FlowHBImpl(Elem("footer"), globalAttributes)
  val address = FlowHBImpl(Elem("address"), globalAttributes)

  val p = PhrasingHBImpl(Elem("p"), globalAttributes)
  val hr = new EmptyPhrasingHB(Elem("hr"), globalAttributes)
  val pre = PhrasingHBImpl(Elem("pre"), globalAttributes)
  val blockquote = FlowHBImpl(Elem("blockquote"), globalAttributes)
  
  val ol = new UlHB(Elem("ol"))
  val ul = new UlHB(Elem("ul"))
  val li = new LiHB.HBImpl(Elem("li"))

  val dl = new DlHB(Elem("dl"))
  val dt = new DlContentHB.HBImpl(Elem("dt"))
  val dd = new DlContentHB.HBImpl(Elem("dd"))
  
  val figure = FlowHBImpl(Elem("figure"), globalAttributes)
  val figcaption = FlowHBImpl(Elem("figcaption"), globalAttributes)
  val div = FlowHBImpl(Elem("div"), globalAttributes)
  val a = PhrasingHBImpl(Elem("a"), new AElementAttributes)
  val em = PhrasingHBImpl(Elem("em"), globalAttributes)
  val strong = PhrasingHBImpl(Elem("strong"), globalAttributes)
  val small = PhrasingHBImpl(Elem("small"), globalAttributes)
  val s = PhrasingHBImpl(Elem("s"), globalAttributes)
  val cite = PhrasingHBImpl(Elem("cite"), globalAttributes)
  val q = PhrasingHBImpl(Elem("q"), new QElementAttributes)
  val dfn = PhrasingHBImpl(Elem("dfn"), globalAttributes)
  val abbr = PhrasingHBImpl(Elem("abbr"), globalAttributes)
  
  val time = PhrasingHBImpl(Elem("time"), new TimeElementAttributes)
  val code = PhrasingHBImpl(Elem("code"), globalAttributes)
  val Var = PhrasingHBImpl(Elem("var"), globalAttributes)
  val samp = PhrasingHBImpl(Elem("samp"), globalAttributes)
  val kbd = PhrasingHBImpl(Elem("kbd"), globalAttributes)
  val sub = PhrasingHBImpl(Elem("sub"), globalAttributes)
  val sup = PhrasingHBImpl(Elem("sup"), globalAttributes)
  val i = PhrasingHBImpl(Elem("i"), globalAttributes)
  val b = PhrasingHBImpl(Elem("b"), globalAttributes)
  val u = PhrasingHBImpl(Elem("u"), globalAttributes)
  val mark = PhrasingHBImpl(Elem("mark"), globalAttributes)
  val bdi = PhrasingHBImpl(Elem("bdi"), globalAttributes)
  val dbo = PhrasingHBImpl(Elem("dbo"), globalAttributes)
  val span = PhrasingHBImpl(Elem("span"), globalAttributes)
  val br = new EmptyPhrasingHB(Elem("br"), globalAttributes)
  val wbr = new EmptyPhrasingHB(Elem("wbr"), globalAttributes)
  
  var ruby = new RubyHB(Elem("ruby"))
  var rt = new RubyContentHBImpl(Elem("rt"))
  var rp = new RubyContentHBImpl(Elem("rp"))
  
  val ins = FlowHBImpl(Elem("ins"), new InsDelAttributes)
  val del = FlowHBImpl(Elem("del"), new InsDelAttributes)
  
  val img = new EmptyPhrasingHB(Elem("img"), new ImgElementAttributes)
  val iframe = new IFrameHB(Elem("iframe"))
  val embed = new EmptyPhrasingHB(Elem("embed"), new EmbedElementAttributes)
  
  val Object = new ObjectHB(Elem("object"))
  val param = new ParamHB(Elem("param"))
  val video = new VideoHB(Elem("video"))
  val audio = new AudioHB(Elem("audio"))
  
  val source = new SourceHB(Elem("source"))
  val track = new TrackHB(Elem("track"))
  
  val canvas = FlowHBImpl(Elem("canvas"), new CanvasElementAttributes)
  val area = new EmptyPhrasingHB(Elem("area"), new AreaElementAttributes)
  
  val table = new TableHB(Elem("table"))

  val caption = new CaptionHB(Elem("caption"))
  val colGroup = new ColgroupHB(Elem("colgroup"))
  val col = new ColHB(Elem("col"))
  
  val tbody = new TrContainerHB(Elem("tbody"))
  val thead = new TrContainerHB(Elem("thead"))
  val tfoot = new TrContainerHB(Elem("tfoot"))

  val tr = new TrHB(Elem("tr"))

  val td = new TdHB(Elem("td"))
  val th = new ThHB(Elem("th"))

  val form = FlowHBImpl(Elem("form"), new FormElementAttributes)
  val label = PhrasingHBImpl(Elem("label"), new LabelElementAttributes)
  
  val input = new EmptyPhrasingHB(Elem("input"), new InputElementAttributes)
  val fieldSet = new FieldsetHB(Elem("fieldset"))
  val legend = new LegendHB(Elem("legend"))
  
  val button = PhrasingHBImpl(Elem("button"), new ButtonElementAttributes)
  
  val select = new SelectHB(Elem("select"))
  val option = new OptionHB.HBImpl(Elem("option"))
  val optGroup = new OptGroupHB(Elem("optGroup"))
  val datalist = new DatalistHB(Elem("datalist"))
   
  val textarea = new TextareaHB(Elem("textarea")) 
  val keygen = new EmptyPhrasingHB(Elem("keygen "), new KeygenElementAttributes)
  val output = PhrasingHBImpl(Elem("output"), new OutputElementAttributes)
  val progress = PhrasingHBImpl(Elem("progress"), new ProgressElementAttributes)
  
  val menu = FlowHBImpl(Elem("menu"), new MenuElementAttributes)
  val summary = new SummaryHB(Elem("summary"))
  val details = new DetailsHB(Elem("details"))
  
}